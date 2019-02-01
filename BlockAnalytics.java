import java.util.*; 

public class BlockAnalytics
{
	private LinkedList<Node> blockChain;
	private Map<String, Node> lookup;

	public BlockAnalytics() 
	{
		blockChain = new LinkedList<Node>();
		lookup = new HashMap<String, Node>();
	}

	public Node searchBlockNumber(String blockNumber)
	{
		Transaction.printHeader();		
		Node node = null;

		if(lookup.containsKey(blockNumber)) {
                        node = lookup.get(blockNumber);
			ArrayList<Transaction> relatedTrans = node.getTransactions();
			for (Transaction trans : relatedTrans) {
				System.out.println(trans.toString());
			}
			return node;
                } else {
			System.out.println("Block not found");
                }

		return null;
	}
	
        public Node searchTransactionHash(String transactionHash)
	{
		System.out.println("(Searching for: " + transactionHash);
		System.out.println("Blockno\tindex\tTXN Fee(ETH)\tTx hash");
		for(Node node : blockChain) {
			ArrayList<Transaction> relatedTrans = node.getTransactions();

			for (Transaction trans : relatedTrans) {
				if(trans.txnHash().equals(transactionHash)) {
					System.out.println(node.blockNumber()+"\t"+trans.index()+"\t"+node.gasUsed()+"\t"+transactionHash);
					return node;
				}
			}
		}

		System.out.println("Transaction hash not found");

		return null;
	}

        public double totalFeesTransactionFrom(String transactionFrom)
        {
                System.out.println("(Searching transactions from: " + transactionFrom);
		Transaction.printHeader();
		double totalFees = 0.0;
                for(Node node : blockChain) {
                        ArrayList<Transaction> relatedTrans = node.getTransactions();

                        for (Transaction trans : relatedTrans) {
                                if(trans.from().equals(transactionFrom)) {
                                        System.out.println(trans.toString());
					totalFees += Double.parseDouble(node.gasUsed());
                                }
                        }
                }

		System.out.println("Total Transaction Fee (ETH): " + totalFees);

                return totalFees;
        }

        public double totalFeesTransactionTo(String transactionTo)
        {
                System.out.println("(Searching transactions to: " + transactionTo);
                Transaction.printHeader();
                double totalFees = 0.0;
                for(Node node : blockChain) {
                        ArrayList<Transaction> relatedTrans = node.getTransactions();

                        for (Transaction trans : relatedTrans) {
                                if(trans.to().equals(transactionTo)) {
                                        System.out.println(trans.toString());
                                        totalFees += Double.parseDouble(node.gasUsed());
                                }
                        }
                }

                System.out.println("Total Transaction Fee (ETH): " + totalFees);

                return totalFees;
        }




	public void addBlock(String blockHash, String blockNumber, int size, String timeStamp, String totalDifficulty, String miner, String gasLimit, String gasUsed)
	{
		Block block = new Block(blockHash, blockNumber, size, timeStamp, totalDifficulty, miner, gasLimit, gasUsed);
		Node node = null;
		if(lookup.containsKey(blockNumber)) {
			node = lookup.get(blockNumber);	
			node.replaceBlock(block);
		} else {
			node = new Node(block);
			blockChain.add(node);
		}
		lookup.put(blockNumber, node);
	}

	public void addTransaction(String blockHash, String blockNumber, String from, String to, String contractId, String gasPrice, String txnHash, String index, String value)	 throws Exception {
		Node node = null;
		if(lookup.containsKey(blockNumber)) {
                        node = lookup.get(blockNumber);
                        node.addTransaction(blockHash, blockNumber, from, to, contractId, gasPrice, txnHash, index, value);
                } else {
			throw new Exception("Node not found");  
                }
	}

	public void sortByGas()
	{
		Collections.sort(blockChain, new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
				return n1.compareGasUsed(n2);
				}
				});

	}

        public void sortByGasPrice()
        {
		for (Node block : blockChain) {
			block.sortByGasPrice();
		}

        }


	public void sortByTransCount()
	{

                Collections.sort(blockChain, new Comparator<Node>() {
                                @Override
                                public int compare(Node n1, Node n2) {
                                return n1.getTransactions().size() - n2.getTransactions().size();
                                }
                                });
	}


	public void printList() 
	{
		Block.printHeader();
		for (Node temp : blockChain) {
			System.out.println(temp.getBlock().toString());
		}
	}

	public void printTransactionList() 
	{
		Transaction.printHeader();
		for (Node temp : blockChain) {
			ArrayList<Transaction> relatedTrans = temp.getTransactions();
			for (Transaction trans : relatedTrans) {
				System.out.println(trans);
			}
		}
	}

}


