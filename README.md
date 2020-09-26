# Firebase-Google-Facebook-Authentication

Implemented Firebase Google SignIn

Few Points to remember while doing this...

1. Create an Oauth Credential in Google Developer console id by selecting Creating new Credentials for Android in your project.
2. Put the package name and SHA1 release key (not debug key) into the field and save it.
3. This will allow us to use the google sign-in feature in signed apk.

We can get release key from initial generation of signed apk .jks file using Keystore Explorer software.
