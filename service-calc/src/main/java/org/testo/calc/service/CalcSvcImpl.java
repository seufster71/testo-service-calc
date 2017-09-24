package org.testo.calc.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Service;
import org.testo.core.service.ServiceProcessor;
import org.testo.core.utils.ErrorMsg;
import org.testo.core.utils.GlobalConstant;
import org.testo.core.utils.Request;
import org.testo.core.utils.Response;


@Service("CalcSvc")
public class CalcSvcImpl implements ServiceProcessor, CalcSvc {

	@Override
	public void process(Request request, Response response) {
	
		String action = (String) request.getParams().get("action");
		switch (action) {
			case "EXEC":
				this.exec(request, response);
				break;
			default:
				ErrorMsg.addMsg(response, GlobalConstant.WARN, "The action does not exist!");
				break;
		}
		
	}

	@Override
	public void exec(Request request, Response response){
		try {
			// validate msadd
			String msadd = (String) request.getParams().get("msadd");
			if (msadd != null && !msadd.isEmpty()) {
				Number number = NumberFormat.getCurrencyInstance(Locale.US).parse(msadd);
				
				BigDecimal x = new BigDecimal(msadd);
				BigDecimal y = x.add(new BigDecimal(20));
				
				response.getParams().put("msaddresult", y.setScale(2).toString());
			} else {
				ErrorMsg.addMsg(response, GlobalConstant.FAIL, "msadd is empty");
			}
		} catch (Exception e) {
			ErrorMsg.addMsg(response, GlobalConstant.FAIL, e.getMessage());
			e.printStackTrace();
		}
	}

}
