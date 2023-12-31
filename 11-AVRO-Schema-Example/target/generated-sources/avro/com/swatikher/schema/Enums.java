/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.swatikher.schema;

@org.apache.avro.specific.AvroGenerated
public interface Enums {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Enums\",\"namespace\":\"com.swatikher.schema\",\"types\":[{\"type\":\"enum\",\"name\":\"InventoryStatus\",\"symbols\":[\"ADJUSTED_OUT\",\"AGED\",\"CONVERTED\",\"DEMO_CONVERTED\",\"EXCHANGED\",\"GOODS_ISSUE_CANCELLED\",\"IN_TRANSIT\",\"RECEIVED\",\"READY_FOR_PICKUP\",\"SIM_RETURNED\",\"RETURNED\",\"SCRAPPED\",\"SOLD\",\"TRANSFERRED\",\"WARRANTY_CANCELLED\"]},{\"type\":\"enum\",\"name\":\"InventoryCondition\",\"symbols\":[\"BROKEN_PACKAGE\",\"DAMAGED\"]},{\"type\":\"enum\",\"name\":\"InventoryType\",\"symbols\":[\"ASTOCK\",\"DEMO\",\"REFURB\",\"ETC\"]},{\"type\":\"enum\",\"name\":\"ReservationStatus\",\"symbols\":[\"REQUESTED\",\"RESERVED\",\"CANCELED\",\"COMPLETED\",\"EXPIRED\"]},{\"type\":\"enum\",\"name\":\"TransactionTypeCode\",\"symbols\":[\"ADJ\"]},{\"type\":\"enum\",\"name\":\"AdjustmentType\",\"symbols\":[\"A\",\"S\",\"M\"]}],\"messages\":{}}");

  @SuppressWarnings("all")
  public interface Callback extends Enums {
    public static final org.apache.avro.Protocol PROTOCOL = com.swatikher.schema.Enums.PROTOCOL;
  }
}