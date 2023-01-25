# bdkpython 0.25.0
# 
# Query an Electrum server for the total balance of a wallet.

import bdkpython as bdk


descriptor = bdk.Descriptor(
    "wpkh([c258d2e4/84h/1h/0h]tpubDDYkZojQFQjht8Tm4jsS3iuEmKjTiEGjG6KnuFNKKJb5A6ZUCUZKdvLdSDWofKi4ToRCwb9poe1XdqfUnP4jaJjCB2Zwv11ZLgSbnZSNecE/0/*)",
    bdk.Network.TESTNET,
)
db_config = bdk.DatabaseConfig.MEMORY()
blockchain_config = bdk.BlockchainConfig.ELECTRUM(
    bdk.ElectrumConfig(
        url="ssl://electrum.blockstream.info:60002",
        socks5=None,
        retry=5,
        timeout=None,
        stop_gap=100,
        validate_domain=True,
    )
)
blockchain = bdk.Blockchain(blockchain_config)

wallet = bdk.Wallet(
             descriptor=descriptor,
             change_descriptor=None,
             network=bdk.Network.TESTNET,
             database_config=db_config,
         )

# print wallet balance
wallet.sync(blockchain, None)
balance = wallet.get_balance()
print(f"Wallet balance is: {balance.total}")
