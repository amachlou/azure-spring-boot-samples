// package amachlou.spring_azure_security_keyvault_secrets;

// import com.azure.identity.ClientSecretCredentialBuilder;
// import com.azure.security.keyvault.secrets.SecretClient;
// import com.azure.security.keyvault.secrets.SecretClientBuilder;

// public class SampleClass {
// final static String VAULT_URL = "";
// final static String TENANT_ID = "";
// final static String CLIENT_ID = "";
// final static String CLIENT_SECRET = "";

// public static void main(String[] args) {
// SecretClient client = new SecretClientBuilder()
// .vaultUrl(VAULT_URL)
// .credential(new ClientSecretCredentialBuilder()
// .tenantId(TENANT_ID)
// .clientId(CLIENT_ID)
// .clientSecret(CLIENT_SECRET)
// .build())
// .buildClient();
// }
// }
