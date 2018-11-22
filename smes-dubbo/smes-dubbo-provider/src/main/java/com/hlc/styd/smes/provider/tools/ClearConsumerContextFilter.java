package com.hlc.styd.smes.provider.tools;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 *
 * dubbo框架增强
 * 自定义filter，消费方完成参数封装后清除线程，解决大对象参数内存溢出问题
 */
@Activate(group = Constants.CONSUMER)
public class ClearConsumerContextFilter implements Filter {

	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		try {
            return invoker.invoke(invocation);
        } finally {
            RpcContext.removeContext();
        }
	}

}
