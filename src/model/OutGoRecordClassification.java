/**
 * 
 */
package model;

import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import com.google.common.collect.Sets;

/**
 * @author murakamitakuya
 * 
 */
public class OutGoRecordClassification extends RecordClassification {
	private static final Set<OutGoRecordClassification> VALUES = Sets
			.newHashSet();

	/**
	 * @param name
	 */
	private OutGoRecordClassification(String name) {
		super(name);
	}

	public static OutGoRecordClassification valueOf(String name) {
		for (OutGoRecordClassification cl : VALUES) {
			if (ObjectUtils.equals(name, cl.getName())) {
				return cl;
			}
		}
		OutGoRecordClassification newClassification = new OutGoRecordClassification(
				name);
		VALUES.add(newClassification);
		return newClassification;
	}

}
