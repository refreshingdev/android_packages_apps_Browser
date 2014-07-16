/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.browserlalia.preferences;

import com.android.browserlalia.PreferenceKeys;
import com.android.browserlalia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;

public class PrivacySecurityPreferencesFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.privacy_security_preferences);

        Preference e = findPreference(PreferenceKeys.PREF_PRIVACY_CLEAR_HISTORY);
        e.setOnPreferenceChangeListener(this);

        ListPreference lp = (ListPreference) findPreference(PreferenceKeys.PREF_SITE_WHITELIST_COOKIES);
        lp.setOnPreferenceChangeListener(this);
        updateListPreferenceSummary(lp);
        cookiesVerboseEnable(lp.getValue());
    }

    private void cookiesVerboseEnable(String str) {
        // if never, disable verbose option
        int value = Integer.valueOf(str);
        Preference pref = findPreference(PreferenceKeys.PREF_SITE_WHITELIST_COOKIES_VERBOSE);
        if (pref != null) {
            pref.setEnabled(value != 0);
        }
    }

    void updateListPreferenceSummary(ListPreference e) {
        e.setSummary(e.getEntry());
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onPreferenceChange(Preference pref, Object objValue) {
        if (pref.getKey().equals(PreferenceKeys.PREF_PRIVACY_CLEAR_HISTORY)
                && ((Boolean) objValue).booleanValue() == true) {
            // Need to tell the browser to remove the parent/child relationship
            // between tabs
            getActivity().setResult(Activity.RESULT_OK, (new Intent()).putExtra(Intent.EXTRA_TEXT,
                    pref.getKey()));
            return true;
        }
        else if (pref.getKey().equals(PreferenceKeys.PREF_SITE_WHITELIST_COOKIES)) {
            ListPreference lp = (ListPreference) pref;
            lp.setValue((String) objValue);
            updateListPreferenceSummary(lp);
            cookiesVerboseEnable((String) objValue);
            return false;
        }

        return false;
    }

}
