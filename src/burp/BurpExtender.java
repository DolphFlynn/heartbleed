package burp;

import javax.swing.*;

import static java.util.Collections.singletonList;

/**
 * Heartbleed extension for burp suite.
 * @author Ashkan Jahanbakhsh
 *
 */

public class BurpExtender implements IBurpExtender {

	@Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
		callbacks.registerContextMenuFactory(invocation -> {
			JMenuItem menuItem = new JMenuItem("Heartbleed this!");
			menuItem.addActionListener(e -> new HeartBleed(callbacks).menuItemClicked(invocation.getSelectedMessages()));

			return singletonList(menuItem);
		});
    }
}