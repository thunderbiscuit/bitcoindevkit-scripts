# bdkpython 0.25.0
#
# Get new addresses from a wallet.

import bdkpython as bdk


descriptor = "wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)"
db_config = bdk.DatabaseConfig.MEMORY()

wallet = bdk.Wallet(
             descriptor=descriptor,
             change_descriptor=None,
             network=bdk.Network.TESTNET,
             database_config=db_config,
         )

# print "last unused" receive address
address_info_last_unused = wallet.get_address(bdk.AddressIndex.LAST_UNUSED)
address_last_unused = address_info_last_unused.address
index_last_unused = address_info_last_unused.index
print(f"Last unused P2PKH testnet address: {address_last_unused} at index {index_last_unused}")

# print new receive address
address_info_new = wallet.get_address(bdk.AddressIndex.NEW)
address_new = address_info_new.address
index_new = address_info_new.index
print(f"New P2PKH testnet address: {address_new} at index {index_new}")
