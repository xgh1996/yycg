import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestShiroRealm2 {
	@Test
	public void shiro() {
		// 通过工厂加载配置文件
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-reaml.ini");
		// 获得安全管理器
		SecurityManager securityManager = factory.getInstance();
		// 注册安全管理器
		SecurityUtils.setSecurityManager(securityManager);
		// 获得主题subject
		Subject subject = SecurityUtils.getSubject();
		// 登录验证
		subject.login(new UsernamePasswordToken("jack1", "1234"));
		
		
		System.out.println("登录成功");
	}
}
