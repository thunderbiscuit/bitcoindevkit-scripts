# Readme
This repo hosts a collection of scripts that make use of the [Bitcoin Development Kit](https://bitcoindevkit.org/) and some of its language bindings.

## Rust Scripts
To run Rust scripts, you'll the need the [rust-script](https://rust-script.org/) tool installed. From there, simply use
```shell
rust-script Rs1.balance.rs
```

## Kotlin Scripts
You can call Kotlin scripts directly like so:
```shell
kotlin Kt1.balance.main.kts
```

## Python Scripts
Python is easy! Just make sure you have the correct packages installed.
```shell
pip3 install bdkpython
python Py1.balance.py
```
