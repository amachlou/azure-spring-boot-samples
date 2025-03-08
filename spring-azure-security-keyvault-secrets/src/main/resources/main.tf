provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "example" {
  name     = "example-resources-123"
  location = "West Europe"
}

resource "azurerm_key_vault" "example" {
  name                = "examplekeyvault12300"  # Ensure this name is globally unique
  location            = azurerm_resource_group.example.location
  resource_group_name = azurerm_resource_group.example.name

  sku_name = "standard"

  tenant_id = data.azurerm_client_config.example.tenant_id

  access_policy {
    tenant_id = data.azurerm_client_config.example.tenant_id
    object_id = data.azurerm_client_config.example.object_id

    secret_permissions = ["Get", "List", "Set", "Delete", "Recover", "Backup", "Restore", "Purge"]

    certificate_permissions = []
    key_permissions         = []
  }
}

data "azurerm_client_config" "example" {}

resource "azurerm_key_vault_secret" "example_secret1" {
  name         = "example-secret1"
  value        = "supersecretvalue1"
  key_vault_id = azurerm_key_vault.example.id
}

resource "azurerm_key_vault_secret" "example_secret2" {
  name         = "example-secret2"
  value        = "supersecretvalue2"
  key_vault_id = azurerm_key_vault.example.id
}

resource "azurerm_key_vault_secret" "example_secret3" {
  name         = "example-secret3"
  value        = "supersecretvalue3"
  key_vault_id = azurerm_key_vault.example.id
}
