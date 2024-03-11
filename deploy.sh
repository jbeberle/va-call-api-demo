az cloud set --name AzureUSGovernment
az login
az webapp list | grep va-veis-vamobile-dev
export ADAL_PYTHON_SSL_NO_VERIFY=1
export AZURE_CLI_DISABLE_CONNECTION_VERIFICATION=1
az webapp deploy --resource-group EIS-DEVTEST-INT-SOUTHWEST-VEIS-RG --name va-veis-vamobile-dev --src-path target/va-call-server-0.0.1-SNAPSHOT.jar
