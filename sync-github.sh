#!/usr/bin/env bash

set -euo pipefail

if ! git rev-parse --is-inside-work-tree >/dev/null 2>&1; then
    echo "Este script debe ejecutarse dentro de un repositorio Git."
    exit 1
fi

branch="$(git branch --show-current)"
remote="${GIT_REMOTE:-origin}"
commit_message="${1:-}"

echo "Repositorio: $(basename "$(git rev-parse --show-toplevel)")"
echo "Rama actual: ${branch}"
echo

git status --short --branch
echo

if [[ -z "${commit_message}" ]]; then
    echo "Uso: ./sync-github.sh \"Mensaje del commit\""
    echo "Ejemplo: ./sync-github.sh \"Actualiza ejercicios de PSP04\""
    exit 1
fi

if [[ -n "$(git status --porcelain)" ]]; then
    echo "Sincronizando antes de guardar cambios..."
    git pull --rebase "${remote}" "${branch}"
    echo

    echo "Preparando cambios..."
    git add -A

    if [[ -n "$(git diff --cached --name-only)" ]]; then
        git commit -m "${commit_message}"
    else
        echo "No hay cambios listos para commit."
    fi
else
    echo "No hay cambios locales. Solo se comprobará el remoto."
fi

echo
echo "Subiendo rama ${branch} a ${remote}..."
git push "${remote}" "${branch}"

echo
echo "Sincronizacion completada."
