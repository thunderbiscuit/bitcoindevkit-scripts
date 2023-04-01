# Readme
This repo hosts a collection of scripts that make use of the [Bitcoin Development Kit](https://bitcoindevkit.org/) and some of its language bindings.

_Total number of scripts: 27_  
<br/>

## Rust Scripts
To run Rust scripts, you'll the need the [rust-script](https://rust-script.org/) tool installed. From there, simply use
```shell
rust-script 1.balance.rs
```
<br/>

## Kotlin Scripts
You can call Kotlin scripts directly like so:
```shell
kotlin 1.balance.main.kts
```

To use a dependency that only exists in your local Maven repository, add the path to your local Maven at the top of the file like so: 
```kotlin
@file:Repository("file:///~/.m2/repository/")
@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.27.0-SNAPSHOT")

import org.bitcoindevkit.*

// ...

```
<br/>

## Python Scripts
Python is easy! Just make sure you have the correct version of the library installed. The `check_bdk_version()` utility function will throw a warning if your version of the library is not the one defined in the script.
```shell
pip3 install bdkpython
python 1.balance.py
```
<br/>

## Swift Scripts
The Swift scripts in this repository use the [swift sh](https://github.com/mxcl/swift-sh) tool, which allows to integrate 3rd-party dependencies in scripts easily. You can install the tool using brew:
```shell
brew install swift-sh
```

From there, simply run the scripts using the following pattern on your command line:
```shell
swift sh 1.balance.swift
```

<br/><br/>

<div align="center">
    <h1>
        <img src="./images/rust.svg" width=200px>
    </h1>
</div>

| File                                                                                    | Task                                                                                                                          |
|-----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| [1.balance.rs](rust/1.balance.rs)                                                       | Query an Electrum server for the balance of a wallet.                                                                         |
| [2.descriptor-templates.rs](rust/2.descriptor-templates.rs)                             | Create public descriptors using the descriptor templates.                                                                     |
| [3.balance-from-rpc.rs](rust/3.balance-from-rpc.rs)                                     | Query a full node through RPC for the balance of a descriptor.                                                                |
| [4.bdk-policy.rs](rust/4.bdk-policy.rs)                                                 | Print the BDK policy for a non-trivial descriptor.                                                                            |
| [5.miniscript-compilation.rs](rust/5.miniscript-compilation.rs)                         | Build a BDK wallet starting from a miniscript policy.                                                                         |
| [6.fee-estimation.rs](rust/6.fee-estimation.rs)                                         | Estimate the fee rate required to confirm a transaction in a given target of blocks.                                          |
| [7.miniscript-policy-parser.rs](rust/7.miniscript-policy-parser.rs)                     | Take a list of pubkeys and a miniscript policy in a json file and spit out another json file with tons of useful information. |

<br/><br/>

<div align="center">
    <h1>
        <img src="./images/kotlin.png" width=200px>
    </h1>
</div>

| File                                                                                    | Task                                                                                                                          |
|-----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| [1.balance.main.kts](kotlin/1.balance.main.kts)                                         | Query an Electrum server for the balance of a wallet.                                                                         |
| [2.blockinfo.main.kts](kotlin/2.blockinfo.main.kts)                                     | Query an Electrum server for the testnet blockchain height and latest block hash.                                             |
| [3.getaddress.main.kts](kotlin/3.getaddress.main.kts)                                   | Get an unused address from a wallet.                                                                                          |
| [4.opreturn.main.kts](kotlin/4.opreturn.main.kts)                                       | Create a transaction with an OP_RETURN output.                                                                                |
| [5.listunspentutxo.main.kts](kotlin/5.listunspentutxo.main.kts)                         | List the unspent outputs this wallet controls.                                                                                |
| [6.descriptor-from-mnemonic.main.kts](kotlin/6.descriptor-from-mnemonic.main.kts)       | Create a BIP84 descriptor starting from a 12-word mnemonic.                                                                   |
| [7.public-descriptor-template.main.kts](kotlin/7.public-descriptor-template.main.kts)   | Create a public descriptor using descriptor templates.                                                                        |
| [8.transaction-details.main.kts](kotlin/8.transaction-details.main.kts)                 | Print transaction details for each transaction the wallet has completed.                                                      |
| [9.private-descriptor-template.main.kts](kotlin/9.private-descriptor-template.main.kts) | Create private and public descriptors using descriptor templates.                                                             |
| [10.create-tx-from-raw-bytes.main.kts](kotlin/10.create-tx-from-raw-bytes.main.kts)     | Create a Transaction object from raw bytes.                                                                                   |

<br/><br/>

<div align="center">
    <h1>
        <img src="./images/swift.png" width=200px>
    </h1>
</div>

| File                                                                                    | Task                                                                                                                          |
|-----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| [1.balance.swift](swift/1.balance.swift)                                                | Query an Electrum server for the balance of a wallet.                                                                         |
| [2.blockinfo.swift](swift/2.blockinfo.swift)                                            | Query an Electrum server for the testnet blockchain height and latest block hash.                                             |
| [3.getaddress.swift](swift/3.getaddress.swift)                                          | Get an unused address from a wallet.                                                                                          |
| [4.opreturn.swift](swift/4.opreturn.swift)                                       | Create a transaction with an OP_RETURN output.                                                                                |
| [5.listunspentutxo.swift](swift/5.listunspentutxo.swift)                         | List the unspent outputs this wallet controls.                                                                                |
| [6.descriptor-from-mnemonic.swift](swift/6.descriptor-from-mnemonic.swift)       | Create a BIP84 descriptor starting from a 12-word mnemonic.                                                                   |
| [7.public-descriptor-template.swift](swift/7.public-descriptor-template.swift)   | Create a public descriptor using descriptor templates.                                                                        |
<br/><br/>

<div align="center">
    <h1>
        <img src="./images/python.png" width=200px>
    </h1>
</div>

| File                                                                                    | Task                                                                                                                          |
|-----------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------| 
| [1.balance.py](python/1.balance.py)                                                     | Query an Electrum server for the balance of a wallet.                                                                         |
| [2.blockinfo.py](python/2.blockinfo.py)                                                 | Query an Electrum server for the testnet blockchain height and latest block hash.                                             |
| [3.getaddress.py](python/3.getaddress.py)                                               | Get new addresses from a wallet.                                                                                              |
