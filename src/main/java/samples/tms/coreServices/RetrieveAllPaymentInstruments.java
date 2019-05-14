package samples.tms.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.InstrumentIdentifierApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.TmsV1InstrumentIdentifiersPaymentInstrumentsGet200Response;
import Model.TmsV1InstrumentIdentifiersPaymentInstrumentsGet200ResponseEmbeddedPaymentInstruments;

/**
 * 
 * Retrieve All Payment instrument identifier
 *
 */
public class RetrieveAllPaymentInstruments {
	private static String profileId = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private static String responseCode = null;
	private static String status = null;
	static TmsV1InstrumentIdentifiersPaymentInstrumentsGet200Response response;
	private static String tokenId = "7010000000016241111";
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception {
		process();
	}

	private static void process() throws Exception {

		try {
			/* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			ApiClient.merchantConfig = merchantConfig;

			InstrumentIdentifierApi instrumentIdentifierApi = new InstrumentIdentifierApi();
			long offset=0;
			long limit=100;
			response = instrumentIdentifierApi.getAllPaymentInstruments(profileId, tokenId, offset, limit);

			responseCode = ApiClient.responseCode;
			status = ApiClient.status;

			System.out.println("ResponseCode :" + responseCode);
			System.out.println("Status :" + status);
			System.out.println("ResponseBody :" + ApiClient.respBody);

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
