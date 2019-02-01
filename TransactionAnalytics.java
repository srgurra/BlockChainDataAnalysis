import java.util.*; 

public class TransactionAnalytics
{
	private LinkedList<Transaction> allTransactions;

	public TransactionAnalytics() 
	{
		allTransactions = new LinkedList<Transaction>();
	}

	public void addTransaction(String blockHash, String blockNumber, String from, String to, String contractId, String gasPrice, String txnHash, String index, String value) {
                        Transaction trans = new Transaction(blockHash, blockNumber, from, to, contractId, gasPrice, txnHash, index, value);
                        allTransactions.add(trans);
	}

	public void sortByPrice()
	{
		Collections.sort(allTransactions, new Comparator<Transaction>() {
				@Override
				public int compare(Transaction t1, Transaction t2) {
				return t1.compareGasPrice(t2.gasPrice());
				}
				});

	}

        public void sortByBlockNumber()
        {
                Collections.sort(allTransactions, new Comparator<Transaction>() {
                                @Override
				public int compare(Transaction t1, Transaction t2) {
						int value1 = t1.compareContractId(t2.contractId());
						if (value1 == 0) {
							return t1.compareBlockNumber(t2.blockNumber());
						}
						return value1;
					}
                                });

        }

	public LinkedList<Transaction> filterContract(String contractId)
	{
		LinkedList<Transaction> filteredTrans = new LinkedList<Transaction>();
		for (Transaction trans : allTransactions) {
			if(trans.contractId().equals(contractId)) {
				filteredTrans.add(trans);
			}
		}

		return filteredTrans;
	}

	public void listMinMaxToken(String contractId)
	{
		LinkedList<Transaction> filteredTrans = filterContract(contractId);
		System.out.println("(Searching transactions of node (Contract ID): "+contractId+")");
		System.out.println("Transaction code with smallest amount of tokens\t\tTransaction code with largest amount of tokens");
		String minTrx = null, maxTrx = null;
		double minValue = 0.0, maxValue = 0.0;

		for(Transaction trans : filteredTrans) {
			if(minTrx == null) {
				minTrx = trans.txnHash();
				maxTrx = trans.txnHash();
				minValue = Double.parseDouble(trans.value());
				maxValue = Double.parseDouble(trans.value());
			}

			if(Double.parseDouble(trans.value()) < minValue) {
				minValue = Double.parseDouble(trans.value());
				minTrx = trans.txnHash();
			}

			if(Double.parseDouble(trans.value()) > maxValue) {
				maxValue = Double.parseDouble(trans.value());
				maxTrx = trans.txnHash();
			}

		}	

		if(minTrx != null) {
			System.out.println(minTrx + "\t" + maxTrx);
		} else {
			System.out.println("Contract id Not found");
		}

	}

	public void printList() {
		Transaction.printHeader();
		for (Transaction trans : allTransactions) {
			System.out.println(trans);
		}
	}

}


