
# StudentCRUD - Start Script

$ErrorActionPreference = "Stop"

$projectRoot = Split-Path -Parent $PSScriptRoot

Push-Location $projectRoot

try {
    Write-Host "Checking Docker Compose configuration..."

    docker compose config --quiet
    if ($LASTEXITCODE -ne 0) {
        throw "Docker Compose configuration failed."
    }

    Write-Host "Building and starting StudentCRUD..."

    docker compose up --build -d
    if ($LASTEXITCODE -ne 0) {
        throw "Failed to start containers."
    }

    Write-Host "Checking container status..."

    docker compose ps
    if ($LASTEXITCODE -ne 0) {
        throw "Failed to check container status."
    }
}
finally {
    Pop-Location
}
