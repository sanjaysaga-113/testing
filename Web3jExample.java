import org.web3j.protocol.*;
import org.web3j.protocol.http.*;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.utils.*;
import java.math.*;

public class Web3jExample {
    public static void main(String[] args) {
        try {
            String infuraUrl = "https://mainnet.infura.io/v3/7238211010344719ad14a89db874158c";
            Web3j web3 = Web3j.build(new HttpService(infuraUrl));

            Web3ClientVersion clientVersion = web3.web3ClientVersion().send();
            System.out.println("Client Version: " + clientVersion.getWeb3ClientVersion());

            EthBlockNumber blockNumber = web3.ethBlockNumber().send();
            System.out.println("Latest Block: " + blockNumber.getBlockNumber());

            String address = "0x742d35Cc6634C0532925a3b844Bc454e4438f44e";
            EthGetBalance balanceResponse = web3.ethGetBalance(address,
                    org.web3j.protocol.core.DefaultBlockParameterName.LATEST).send();

            BigInteger wei = balanceResponse.getBalance();
            BigDecimal eth = Convert.fromWei(new BigDecimal(wei), Convert.Unit.ETHER);

            System.out.println("Balance of " + address + ": " + eth + " ETH");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
