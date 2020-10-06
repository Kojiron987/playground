# -*- coding: -utf-8 -*-

"""
    プロジェクトを作成するスクリプト
"""

from dataclasses import dataclass
import json
import os

class Common:
    group: str
    commonJar: str

class Config:
    projectName: str
    packageName: str
    serviceName: str
    startArgs: str

def load(config_file: str) -> (Common, Config):
    json_load =  json.load(open(config_file, 'r'))

    common =  Common()
    common.group = json_load['common']['group']
    common.commonJar = json_load['common']['commonJar']

    config = Config()
    config.projectName = json_load['config']['projectName']
    config.packageName = json_load['config']['packageName']
    config.serviceName = json_load['config']['serviceName']
    config.startArgs = json_load['config']['startArgs']

    return (common, config)


def create_gradle_file(fileName: str, common: Common, config: Config) -> None:
    with open(fileName, 'w', encoding='utf-8'):
        pass

def create_installer_file(fileName: str, common: Common, config: Config) -> None :

    template = f"""\
@echo off
setlocal
chci 65001
{config.packageName}
{config.serviceName}
        """
    with open(fileName, 'w', encoding='utf-8') as fout :
        fout.write(template)


if __name__ == "__main__":
    print("プロジェクト作成を開始します")
    
    config_file = 'settings.json'
    (common, config) = load(config_file)

    print("プロジェクトフォルダの確認")
    currentDirectory = os.getcwd()

    project_directory = os.path.join(os.getcwd(), config.projectName)

    if os.path.exists(project_directory):
        print("プロジェクトは既に存在します")
        exit()

    src_path = os.path.join(project_directory, 'src', 'main', 'java', config.packageName)
    src_resource_path = os.path.join(project_directory, 'src', 'main', 'resources')
    test_path = os.path.join(project_directory, 'src', 'test', 'java', config.packageName)
    test_resource_path = os.path.join(project_directory, 'src', 'test', 'resources')

    os.makedirs(src_path)
    os.makedirs(src_resource_path)
    os.makedirs(test_path)
    os.makedirs(test_resource_path)

    gradle_build_file = os.path.join(project_directory, 'build.gradle')
    create_gradle_file(gradle_build_file, common, config)


    service_path = os.path.join(project_directory, 'scripts')
    os.makedirs(service_path)

    installer_file = os.path.join(service_path, 'Install.cmd')
    create_installer_file(installer_file, common, config)

