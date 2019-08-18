package com.xebia.retail;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xebia.retail.controller.PurchaseController;
import com.xebia.retail.service.ItemPurchaseService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PurchaseController.class, secure = false)
public class PurchaseAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemPurchaseService ItemPurchaseService;

	

	String exampleCourseJson = "{\"customer\":{\"customerName\":\"Sudhir Mishra\",\"customerId\":\"12345\",\"customerType\":\"EMP\",\"customerRelationAgeInYrs\":2},\"itemList\":[{\"itemName\":\"Pen Drive\",\"itemCode\":\"7764\",\"itemPrice\":1000,\"itemCategory\":\"groceries\"},{\"itemName\":\"LED TV\",\"itemCode\":\"2245\",\"itemPrice\":100,\"itemCategory\":\"ELECTRONICS\"}]}";


	@Test
	public void purchaseCall() throws Exception {
		

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/purchase/calculate")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

		//assertEquals("http://localhost:8080/purchase/calculate",
				//response.getHeader(HttpHeaders.LOCATION));

	}

}