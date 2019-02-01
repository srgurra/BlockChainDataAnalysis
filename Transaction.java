

class Transaction
{
	private String blockHash;
	private String blockNumber;
	private String from;
	private String to; 
	private String contractId;
	private String gasPrice;
	private String txnHash;
	private String index;
	private String value;

	public Transaction(String blockHash, String blockNumber, String from, String to, String contractId, String gasPrice, String txnHash, String index, String value) 
	{
		this.blockHash = blockHash;
		this.blockNumber = blockNumber;
		this.from = from;
		this.to = to;
		this.contractId = contractId;
		this.gasPrice = gasPrice;
		this.txnHash = txnHash;
		this.index = index;
		this.value = value;
	}

	public String txnHash()
	{
		return txnHash;
	}

	public String contractId()
	{
		return contractId;
	}

        public String value()
        {
                return value;
        }


	public String index()
	{
		return index;
	}

        public String from()
        {
                return from;
        }

        public String to()
        {
                return to;
        }

	public String blockId() 
	{
		return blockHash;
	} 

	public int compareGasPrice(String gasPrice) 
	{
		return Double.compare(Double.parseDouble(this.gasPrice), Double.parseDouble(gasPrice));
	}

	public int compareBlockNumber(String blockNumber)
	{
		return Double.compare(Double.parseDouble(this.blockNumber), Double.parseDouble(blockNumber));
	}

        public int compareContractId(String contractId)
        {
                return this.contractId.compareTo(contractId);
        }


	public String blockNumber()
	{
		return this.blockNumber;
	}




	public String gasPrice()
	{
		return this.gasPrice;
	}


	public static void printHeader()
	{
		System.out.println("block hash\tblock number\tfrom\tto\tcontract id\tgas price\ttxn hash\tindex\tvalue(token)");
	}

	@Override
		public String toString() {
			return blockHash + "\t" + blockNumber + "\t" + from + "\t" + to + "\t" + contractId + "\t" + gasPrice + "\t" + txnHash + "\t" + index + "\t" + value;
		}

}
