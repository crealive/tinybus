package com.halfbit.tinybus.mocks;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Assert;

public abstract class Callbacks {

	private final ArrayList<Object> mEvents = new ArrayList<Object>();
	
	protected void onCallback(Object event) {
		mEvents.add(event);
	}
	
	public void assertNullEvent() {
		Assert.assertEquals(1, mEvents.size());
		Assert.assertSame(null, mEvents.get(0));
	}
	
	public void assertEventsList(ArrayList<Object> expectedEvents) {
		Assert.assertEquals(expectedEvents.size(), mEvents.size());
		for(int i=0; i<expectedEvents.size(); i++) {
			Assert.assertSame(expectedEvents.get(0), mEvents.get(0));
		}
	}
	
	public void assertEvents(Object... expectedEvents) {
		Assert.assertEquals(expectedEvents.length, mEvents.size());
		for(int i=0; i<expectedEvents.length; i++) {
			Assert.assertSame(expectedEvents[i], mEvents.get(i));
		}
	}
	
	public void assertEventsAnyOrder(Object... expectedEvents) {
		Assert.assertEquals(expectedEvents.length, mEvents.size());
		ArrayList<Object> events = new ArrayList<Object>(Arrays.asList(expectedEvents));
		
		for(int i=0; i<expectedEvents.length; i++) {
			Assert.assertTrue("cannot find event: " + expectedEvents[i], events.remove(expectedEvents[i]));
		}
		Assert.assertEquals("unexpected events: " + events, 0, events.size());
	}
	
	public void assertNoEvents() {
		Assert.assertEquals(0, mEvents.size());
	}
	
	public void clearEvents() {
		mEvents.clear();
	}
	
	public int getEventsCount() {
		return mEvents.size();
	}
	
}
