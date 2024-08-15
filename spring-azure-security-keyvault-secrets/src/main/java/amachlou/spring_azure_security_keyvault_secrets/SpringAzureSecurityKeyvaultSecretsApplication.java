package amachlou.spring_azure_security_keyvault_secrets;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@AllArgsConstructor
@EnableConfigurationProperties(KeyVaultProperties.class)
public class SpringAzureSecurityKeyvaultSecretsApplication implements CommandLineRunner {

	private KeyVaultProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureSecurityKeyvaultSecretsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SecretClient client = new SecretClientBuilder()
				.vaultUrl(properties.getVaultUrl())
				.credential(new ClientSecretCredentialBuilder()
						.tenantId(properties.getTenantId())
						.clientId(properties.getClientId())
						.clientSecret(properties.getClientSecret())
						.build())
				.buildClient();

//		System.out.println("Secret: "+client.getSecret("example-secret1 ---> ").getValue());
//		System.out.println("Secret: "+client.getSecret("secret").getValue());
	}
}
