


public class Driver
{
	private static String blockFileName = "blocks (10172018).csv";
	private static String transactionFileName = "transactions (10172018).csv";

	public static void blockAnalyticsOne() throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlocksOnly();

		long startTime = System.currentTimeMillis();
		analytics.sortByGas();
		long endTime = System.currentTimeMillis();
		System.out.println("1.Sorting Blocks by Gas Used increasing:");
		analytics.printList();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Sorting Blocks by Gas Used increasing on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

	}

	public static void blockAnalyticsTwo() throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();
		long startTime = System.currentTimeMillis();
		analytics.sortByTransCount();
		long endTime = System.currentTimeMillis();
		System.out.println("2.Sorting Blocks by number of Transaction increasing (cross refrensed to transaction to compare number of transactions in each block):");
		analytics.printList();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Sorting Blocks by number of Transaction increasing on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

	}

	public static void blockAnalyticsThree() throws Exception
	{
		TransactionAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadTransactionsOnly();
		long startTime = System.currentTimeMillis();
		analytics.sortByPrice();
		long endTime = System.currentTimeMillis();
		System.out.println("3.Sorting Transactions by Transaction Fee (gas Price) increasing:");
		analytics.printList();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Sorting Blocks by Transaction Fee (ETH) increasing on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");
	}

	public static void blockAnalyticsFour() throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();

		long startTime = System.currentTimeMillis();
		analytics.sortByGasPrice();
		long endTime = System.currentTimeMillis();
		System.out.println("4.sort all transactions per block in an increasing order of gas fee:");
		analytics.printTransactionList();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of sort all transactions per block in an increasing order of gas fee on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

	}

	public static void blockAnalyticsFive() throws Exception
	{
		TransactionAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadTransactionsOnly();

		long startTime = System.currentTimeMillis();
		analytics.sortByBlockNumber();
		long endTime = System.currentTimeMillis();
		System.out.println("5.sort all transactions per contract Add in an increasing order of block#(Quick Sort) :");
		analytics.printList();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of sort all transactions per contract Add in an increasing order of block# on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");
	}

	public static void blockAnalyticsSix(String searchBlockNumber) throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();

		System.out.println("6.Searching for a particular Block# (3110014 in this case) and display its transaction List:");
		long startTime = System.currentTimeMillis();
		analytics.searchBlockNumber(searchBlockNumber);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Searching for a particular Block# (3110014 in this case) and display its transaction List on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

	}

	public static void blockAnalyticsSeven(String searchTransactionHash) throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();
		System.out.println("7.Searching for a particular Transaction Hash# and display its Block# and gas fee:");
		long startTime = System.currentTimeMillis();
		analytics.searchTransactionHash(searchTransactionHash);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Searching for a particular Transaction Hash# and display its Block# and gas fee, on the whole data(in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

	}

	public static void blockAnalyticsEight(String searchTransactionFrom) throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();
		System.out.println("8.Identify and list up all transactions from a particular node (public key) and its total transaction fee:");
		long startTime = System.currentTimeMillis();
		analytics.totalFeesTransactionFrom(searchTransactionFrom);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Identify and list up all transactions from a particular node (public key), on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");
	}

	public static void blockAnalyticsNine(String searchTransactionTo) throws Exception
	{
		BlockAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadBlockTransactions();
		System.out.println("9.Identify and list up all transactions to a particular node (public key):");
		long startTime = System.currentTimeMillis();
		analytics.totalFeesTransactionTo(searchTransactionTo);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Identify and list up all transactions to a particular node (public key), on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");
	}

	public static void blockAnalyticsTen(String searchContractId) throws Exception
	{
		TransactionAnalytics analytics = new LoadBlockchain(blockFileName, transactionFileName).loadTransactionsOnly();
		System.out.println("10.Identify and returns the transaction ID in a particular node (Contract ID) with the Smallest and largest amount of tokens:");
		long startTime = System.currentTimeMillis();
		analytics.listMinMaxToken(searchContractId);
		long endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Identify and list up all transactions to a particular node (public key), on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");
	}

	public static void blockAnalyticsEleven() throws Exception
	{
		String bfsStart = "0x107af532e6f828da6fe79699123c9a5ea0123d16";
		System.out.println("11.Build a graph from the list of from's and to's of Transactions:");
		System.out.println("Graph Loading, Please wait!");
		long startTime = System.currentTimeMillis();
		TransactionGraph graph = new LoadBlockchain(blockFileName, transactionFileName).loadTransactionGraph();
		graph.printGraph();
		long endTime = System.currentTimeMillis();

		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of Building a graph from the list of from's and to's of Transaction and tokens, on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");

		System.out.println("Calling BFS function on the created graph and "+ bfsStart +" as the starting node:");
		System.out.println("The shortest path from "+ bfsStart +" to other accessible nodes accordint to BFS:");
		startTime = System.currentTimeMillis();
		graph.printBFS(bfsStart);
		endTime = System.currentTimeMillis();
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("running time of BFS, on the whole data (in milliseconds): " + (endTime-startTime));
		System.out.println("");
		System.out.println("");


		System.out.println("Calling DFS function on the created graph:");
		System.out.println("Printing the node Id's accordion to DFS");
		startTime = System.currentTimeMillis();
		graph.printDFS(bfsStart);
		endTime = System.currentTimeMillis();
		System.out.println("");
                System.out.println("--------------------------------------");
                System.out.println("running time of DFS, on the whole data (in milliseconds): " + (endTime-startTime));
                System.out.println("");
                System.out.println("");


	}





	public static void main(String args[]) throws Exception
	{
		
		  blockAnalyticsOne();
		  blockAnalyticsTwo();
		  blockAnalyticsThree();
		  blockAnalyticsFour();
		  blockAnalyticsFive();
		  blockAnalyticsSix("3110014");
		  blockAnalyticsSeven("0xa9d277515575dac423ef0fe84b5cb522debb61112665cb719ed61c8557e1d9ef");
		  blockAnalyticsEight("0xa455232135b2d6f2e50d7a1131d7e5752f9cb77d");
		  blockAnalyticsNine("0x7b36d8be6f92818dc30f532ae2a67128b4b92b21");
		  blockAnalyticsTen("0xc25b3dbbfe2d84c1195b8b73dc61a306720cbfc6");
		blockAnalyticsEleven();
	}

}


