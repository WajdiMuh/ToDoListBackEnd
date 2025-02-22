//package TDLBackend.tdl.websockets;
//
//import TDLBackend.tdl.Item.Item;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//public class SocketController {
//
//	@MessageMapping("/item.delete")
//	@SendTo("/topic/public")
//	public List<Item> sendMessage(int id) {
//		return {};
//	}
//
//	@MessageMapping("/item.add")
//	@SendTo("/topic/public")
//	public Item addItem() {
//		return new Item();
//	}
//
//	@MessageMapping("/item.check")
//	@SendTo("/topic/public")
//	public  void checkitem() {
//
//	}
//}