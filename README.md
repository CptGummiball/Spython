![Logo](https://github.com/CptGummiball/Spython/blob/main/logo.png?raw=true)


# Spython Plugin
![Version](https://img.shields.io/badge/v-1.0-blue.svg) [![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE) ![Spigot](https://img.shields.io/badge/Spigot-1.20-orange.svg)

## Overview
The **Spython** plugin for Spigot allows you to run Python scripts using GraalVM's polyglot capabilities.
## Usage
### Commands
- `/executepython <scriptpath>`: Executes a Python script on the server.
  - Permission: `spython.executepython`
  - If the scripts are in the Spython `script` folder, they will be listed in the tab completer
### Installation
1. Standalone Usage
- Download the latest version of the Spython.jar file from the releases page.
- Place it in the plugins folder of your Spigot server.
- Start or restart your Spigot server.
2. [Using Spython as a Dependency](https://github.com/CptGummiball/Spython/wiki/Using-Spython-as-a-Dependency)
3. [Adding additional libaries](https://github.com/CptGummiball/Spython/wiki/Integrated-Libaries)

### Running Python Scripts in standalone usage
1. Place your Python scripts in the server's directory where the Spigot plugins are located.
2. In-game, execute the /executepython command to run a Python script.
`/executepython <scriptpath>`


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. The MIT License is a permissive open-source license that allows for flexibility in how the code can be used and shared.

## Support and Issues:

For support or reporting issues, please visit the [Spython GitHub repository](https://github.com/CptGummiball/Spython/) and open a new [issue.](https://github.com/CptGummiball/Spython/issues)
