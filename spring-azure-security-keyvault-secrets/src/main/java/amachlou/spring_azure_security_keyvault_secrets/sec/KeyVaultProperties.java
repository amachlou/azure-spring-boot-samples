package amachlou.spring_azure_security_keyvault_secrets.sec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter @AllArgsConstructor
@ConfigurationProperties("azure.keyvault")
public class KeyVaultProperties {
    private String vaultUrl;
    private String tenantId;
    private String clientId;
    private String clientSecret;



}
