Beim drehen des Handys ging die Nachtabstimmung immer verloren.
So bleibt die Konfiguration beim Drehen erhalten!!!

+++++++++++++++Das Attribut hinzufügen in der Activity des Manifest.xml

android:configChanges="orientation|screenSize">

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


Beispiel:

<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:configChanges="orientation|screenSize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>