# Description
This projects shows an error with openpdf and jasperreports.

# Configuration
You need to configure the exportdirectory for the generated pdf in the application.properties file.

# Reproducing the error
When using openpdf the bold fonts are too thick.
When switching openpdf in the pom.xml file to itext, you can see the bold fonts are not too thick.
