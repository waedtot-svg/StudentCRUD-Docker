
# StudentCRUD - Status Script

$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot

Push-Location $projectRoot

try {
    Write-Host "Checking StudentCRUD container status..."

    docker compose ps

    if ($LASTEXITCODE -ne 0) {
        throw "Failed to check container status."
    }
}
finally {
    Pop-Location
}
