package samples.riskManagement.coreServices;

import java.util.*;
import com.cybersource.authsdk.core.MerchantConfig;

import Api.*;
import Data.Configuration;
import Invokers.ApiClient;
import Model.*;

public class MultipleLineItems {
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static RiskV1AddressVerificationsPost201Response run() {
	
		VerifyCustomerAddressRequest requestObj = new VerifyCustomerAddressRequest();

		Riskv1addressverificationsClientReferenceInformation clientReferenceInformation = new Riskv1addressverificationsClientReferenceInformation();
		clientReferenceInformation.code("addressEg");
		clientReferenceInformation.comments("dav-All fields");
		requestObj.clientReferenceInformation(clientReferenceInformation);

		Riskv1addressverificationsOrderInformation orderInformation = new Riskv1addressverificationsOrderInformation();
		Riskv1addressverificationsOrderInformationBillTo orderInformationBillTo = new Riskv1addressverificationsOrderInformationBillTo();
		orderInformationBillTo.address1("12301 research st");
		orderInformationBillTo.address2("1");
		orderInformationBillTo.address3("2");
		orderInformationBillTo.address4("3");
		orderInformationBillTo.administrativeArea("TX");
		orderInformationBillTo.country("US");
		orderInformationBillTo.locality("Austin");
		orderInformationBillTo.postalCode("78759");
		orderInformation.billTo(orderInformationBillTo);

		Riskv1addressverificationsOrderInformationShipTo orderInformationShipTo = new Riskv1addressverificationsOrderInformationShipTo();
		orderInformationShipTo.address1("PO Box 9088");
		orderInformationShipTo.address2("");
		orderInformationShipTo.address3("");
		orderInformationShipTo.address4("");
		orderInformationShipTo.administrativeArea("California");
		orderInformationShipTo.country("US");
		orderInformationShipTo.locality("San Jose");
		orderInformationShipTo.postalCode("95132");
		orderInformation.shipTo(orderInformationShipTo);


		List <Riskv1addressverificationsOrderInformationLineItems> lineItems =  new ArrayList <Riskv1addressverificationsOrderInformationLineItems>();
		Riskv1addressverificationsOrderInformationLineItems lineItems1 = new Riskv1addressverificationsOrderInformationLineItems();
		lineItems1.unitPrice("120.50");
		lineItems1.quantity(3);
		lineItems1.productSKU("9966223");
		lineItems1.productName("headset");
		lineItems1.productCode("electronix");
		lineItems.add(lineItems1);

		Riskv1addressverificationsOrderInformationLineItems lineItems2 = new Riskv1addressverificationsOrderInformationLineItems();
		lineItems2.unitPrice("10.50");
		lineItems2.quantity(2);
		lineItems2.productSKU("9966226");
		lineItems2.productName("wwrdf");
		lineItems2.productCode("electronic");
		lineItems.add(lineItems2);

		orderInformation.lineItems(lineItems);

		requestObj.orderInformation(orderInformation);

		Riskv1addressverificationsBuyerInformation buyerInformation = new Riskv1addressverificationsBuyerInformation();
		buyerInformation.merchantCustomerId("QWERTY");
		requestObj.buyerInformation(buyerInformation);

		RiskV1AddressVerificationsPost201Response result = null;
		try {
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			VerificationApi apiInstance = new VerificationApi(apiClient);
			result = apiInstance.verifyCustomerAddress(requestObj);

			responseCode = apiClient.responseCode;
			status = apiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		
			run();
	}
}
