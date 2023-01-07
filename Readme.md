# Readme
This repo hosts a collection of scripts that make use of the [Bitcoin Development Kit](https://bitcoindevkit.org/) and some of its language bindings.

## Rust Scripts
To run Rust scripts, you'll the need the [rust-script](https://rust-script.org/) tool installed. From there, simply use
```shell
rust-script 1.balance.rs
```

## Kotlin Scripts
You can call Kotlin scripts directly like so:
```shell
kotlin 1.balance.main.kts
```

## Python Scripts
Python is easy! Just make sure you have the correct packages installed.
```shell
pip3 install bdkpython
python 1.balance.py
```

## Table of Contents
_Total number of scripts: 10_

| Language | File                                                            | Task                                                                              |
|----------|-----------------------------------------------------------------|-----------------------------------------------------------------------------------|
| Rust     | [1.balance.rs](rust/1.balance.rs)                               | Query an Electrum server for the balance of a wallet.                             |
| Rust     | [2.descriptortemplates.rs](rust/2.descriptortemplates.rs)       | Create public descriptors using the descriptor templates.                         |

| Language | File                                                            | Task                                                                              |
|----------|-----------------------------------------------------------------|-----------------------------------------------------------------------------------|
| Kotlin   | [1.balance.main.kts](kotlin/1.balance.main.kts)                 | Query an Electrum server for the balance of a wallet.                             |
| Kotlin   | [2.blockinfo.main.kts](kotlin/2.blockinfo.main.kts)             | Query an Electrum server for the testnet blockchain height and latest block hash. |
| Kotlin   | [3.getaddress.main.kts](kotlin/3.getaddress.main.kts)           | Get an unused address from a wallet.                                              |
| Kotlin   | [4.opreturn.main.kts](kotlin/4.opreturn.main.kts)               | Create a transaction with an OP_RETURN output.                                    |
| Kotlin   | [5.listunspentutxo.main.kts](kotlin/5.listunspentutxo.main.kts) | List the unspent outputs this wallet controls.                                    |

| Language | File                                                            | Task                                                                              |
|----------|-----------------------------------------------------------------|-----------------------------------------------------------------------------------|
| Python   | [1.balance.py](python/1.balance.py)                             | Query an Electrum server for the balance of a wallet.                             |
| Python   | [2.blockinfo.py](python/2.blockinfo.py)                         | Query an Electrum server for the testnet blockchain height and latest block hash. |
| Python   | [2.getaddress.py](python/3.getaddress.py)                       | Get new addresses from a wallet.                                                  |
