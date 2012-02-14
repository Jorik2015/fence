package com.abner.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.abner.fence.web.StoreAction;
import com.abner.model.Stock;

import ext.data.Api;

@Controller
@Scope("request")
public class StockAction implements StoreAction {
	private static Random rand = new Random();

	public Object execute(List<?> objs, String api) {
		if (api.equals(Api.ACTION_READ)) {
			List<Stock> stocks = new ArrayList<Stock>();
			for (int i = 0; i < 10; i++) {
				Stock stock = new Stock();
				stock.setName("股票" + i);
				stock.setStockNo("10043" + i + rand.nextInt(500));
				stock.setPrice(20d + rand.nextDouble() / 20);
				stocks.add(stock);
			}
			return stocks;
		}
		return null;
	}
}