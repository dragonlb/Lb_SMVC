var req_data = {
	test0 : {head:{ txn_code:"010102"},
		body:{
			act_type: "010102",
			st_type: "citic"
		}},
	login :	{
		head : {
			txn_code : "000901",
			msg_sender : "bc",
			merchant_id: "1012",
			store_id : "axxl",
			terminal_id : "axxl001",
			req_no : "526582",
			post_time : "2014-08-21 16:27:45"
		},
		body : {}
	},
	trade010102 : {
        body : {
            transCash : "20", 
            secondTrack : "999999999=111111111", 
            act_type : "010102", 
            pan : "999999999" 
            },
        head : {
            req_no : "20140830152712", 
            msg_sender : "bcpos", 
            txn_code : "010102", 
            terminal_id : "axxl001", 
            store_id : "axxl", 
            merchant_id : "1012", 
            post_time : "2014-08-21 15:21:65"
            }
       },
	trade0201 : {
           body : {
               ori_req_no : "999999999",
               reverse_code:"sys_auto",
               reverse_desp:"系统冲正"
               },
           head : {
               req_no : "20140830152712", 
               msg_sender : "webO2O", 
               trade_code : "trade0201", 
               terminal_id : "", 
               store_id : "", 
               merchant_id : "1", 
               trade_account : "1012", 
               post_time : "2014-08-21 15:21:65",
               act_code: '1'
               }
          },
    trade0202 : {
	      body : {
	          ori_req_no : "999999999",
	          cancel_code:"manual",
	          cancel_desp:"人工撤消"
	          },
	      head : {
	          req_no : "20140830152712", 
	          msg_sender : "webO2O", 
	          trade_code : "trade0202", 
	          terminal_id : "", 
	          store_id : "", 
	          merchant_id : "1", 
	          trade_account : "1012", 
	          post_time : "2014-08-21 15:21:65",
	          act_code: '1'
	          }
	     },
       trade0205 : {
           body : {
        	   trade_amt : "5",
        	   goods: [
              	 {goods_num: "1", goods_no: 'wem01'},
        	     {goods_num: "2", goods_no: 'wem02'}
        	   ],
        	   rights_no: '0000002',
               ori_reqno : "999999999"
               },
           head : {
               req_no : "20140830152712", 
               msg_sender : "webO2O", 
               trade_code : "trade0205", 
               terminal_id : "", 
               store_id : "1", 
               merchant_id : "", 
               trade_account : "wlm", 
               post_time : "2014-08-21 15:21:65",
               act_code: '1'
               }
          }
}