![Logo](https://github.com/CptGummiball/Spython/blob/main/logo.png?raw=true)


# Spython Plugin
![Version](https://img.shields.io/badge/v-0.6-blue.svg) [![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE) ![Spigot](https://img.shields.io/badge/Spigot-1.20-orange.svg) ![Paper](https://img.shields.io/badge/PaperMC-1.20-34eba4.svg)

## Overview
The **Spython** plugin for Spigot allows you to run Python scripts using GraalVM's polyglot capabilities.
### Development Note:
Please be aware that Spython is actively being developed to enhance its features and address any existing imperfections. While the plugin is functional, it may not be considered flawless. We appreciate your understanding and welcome feedback as we work to make Spython even better.​
## Usage
### Commands
- `/executepython <scriptpath>`: Executes a Python script on the server.
  - Permission: `spython.executepython`
  - The Tab Completer will list all python scripts that are not in a "libs" folder
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

## Notes

This plugin is currently not very performant. We'll do our best to fix this.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. The MIT License is a permissive open-source license that allows for flexibility in how the code can be used and shared.

## Support and Issues:

For support or reporting issues, please visit the [Spython GitHub repository](https://github.com/CptGummiball/Spython/) and open a new [issue.](https://github.com/CptGummiball/Spython/issues)

## Contributing

Contributions to the project are welcome! Feel free to join the discussion, propose ideas, contribute code, or suggest improvements. Please follow the established [contribution guidelines](https://github.com/CptGummiball/Spython/blob/main/.github/CONTRIBUTING.md) for a smooth collaboration process.

