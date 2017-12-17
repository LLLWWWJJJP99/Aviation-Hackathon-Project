package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

//�Կͻ����ύ�����ݽ���htmlת��
public class HtmlFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		RequestHtmlWrapper myrequest = new RequestHtmlWrapper(request);
		chain.doFilter(myrequest, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}

class RequestHtmlWrapper extends HttpServletRequestWrapper{

	private HttpServletRequest request;
	
	public RequestHtmlWrapper(HttpServletRequest request) {
		super(request);   //super��thisֻ�ܳ����ڵ�һ�У�������һ�����췽�����棬����ͬʱ����super��this
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		
		String value = this.request.getParameter(name);
		return filter(value);
	}
	
	public  String filter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());

    }
	
	
	
	
	
	
}
