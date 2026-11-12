
# StudentCRUD - Stop Script

$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot

Push-Location $projectRoot

try {
    Write-Host "Stopping StudentCRUD containers..."

    docker compose down

    if ($LASTEXITCODE -ne 0) {
        throw "Failed to stop containers."
    }

    Write-Host "StudentCRUD containers stopped successfully."
}
finally {
    Pop-Location
}
