# bdkpython 0.25.0
# 
# Query an Electrum server for the total balance of a wallet.

import bdkpython as bdk


descriptor = "wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)"
db_config = bdk.DatabaseConfig.MEMORY()
blockchain_config = bdk.BlockchainConfig.ELECTRUM(
    bdk.ElectrumConfig(
        "ssl://electrum.blockstream.info:60002",
        None,
        5,
        None,
        100
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
