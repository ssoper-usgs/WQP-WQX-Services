package gov.usgs.cida.wqp.mapping.xml;

import static gov.usgs.cida.wqp.mapping.BaseColumn.*;
import static gov.usgs.cida.wqp.mapping.StationColumn.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import gov.usgs.cida.wqp.mapping.ColumnProfile;

@Component
public class SimpleStationWqxOutbound extends BaseWqx implements IXmlMapping {
	
	public static final String ROOT_NODE_OUTBOUND = "WQX-Outbound";

	public static final Map<String, String> HARD_BREAK = new LinkedHashMap<>();

	public static final Map<String, List<String>> COLUMN_POSITION = new LinkedHashMap<>();
	
	public static final Map<String, List<ColumnProfile>> GROUPING = new LinkedHashMap<>();

	static {
		HARD_BREAK.put(KEY_DATA_SOURCE, ROOT_NODE_OUTBOUND);
		HARD_BREAK.put(KEY_ORGANIZATION, WQX_PROVIDER);
		HARD_BREAK.put(KEY_SITE_ID, WQX_ORGANIZATION);
	}

	static {
		COLUMN_POSITION.put(KEY_DATA_SOURCE,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_PROVIDER_NAME)));
		COLUMN_POSITION.put(KEY_ORGANIZATION,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_ORGANIZATION_DESCRIPTION,
						WQX_ORGANIZATION_IDENTIFIER)));
		COLUMN_POSITION.put(KEY_ORGANIZATION_NAME,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_ORGANIZATION_DESCRIPTION,
						WQX_ORGANIZATION_FORMAL_NAME)));
		COLUMN_POSITION.put(KEY_SITE_ID,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_MONITORING_LOCATION,
						WQX_MONITORING_LOCATION_IDENTITY,
						WQX_MONITORING_LOCATION_IDENTIFIER)));
		COLUMN_POSITION.put(KEY_STATION_NAME,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_MONITORING_LOCATION,
						WQX_MONITORING_LOCATION_IDENTITY,
						WQX_MONITORING_LOCATION_NAME)));
		COLUMN_POSITION.put(KEY_SITE_TYPE,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_MONITORING_LOCATION,
						WQX_MONITORING_LOCATION_IDENTITY,
						WQX_RESOLVED_MONITORING_LOCATION)));
		COLUMN_POSITION.put(KEY_LATITUDE,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_MONITORING_LOCATION,
						WQX_MONITORING_LOCATION_GEOSPATIAL,
						WQX_LATITUDE_MEASURE)));
		COLUMN_POSITION.put(KEY_LONGITUDE,
				new LinkedList<String>(Arrays.asList(WQX_PROVIDER,
						WQX_ORGANIZATION,
						WQX_MONITORING_LOCATION,
						WQX_MONITORING_LOCATION_GEOSPATIAL,
						WQX_LONGITUDE_MEASURE)));
	}
	

	static {
		GROUPING.put(KEY_DATA_SOURCE,
				new LinkedList<ColumnProfile>(Arrays.asList(DATA_SOURCE)));
		GROUPING.put(KEY_ORGANIZATION,
				new LinkedList<ColumnProfile>(Arrays.asList(ORGANIZATION, ORGANIZATION_NAME)));
		GROUPING.put(KEY_SITE_ID,
				new LinkedList<ColumnProfile>(Arrays.asList(SITE_ID,
						STATION_NAME,
						SITE_TYPE,
						LATITUDE,
						LONGITUDE)));
	}
	
	
	@Override
	public String getRoot() {
		return ROOT_NODE_OUTBOUND;
	}

	@Override
	public String getHeader() {
		return "<" + ROOT_NODE_OUTBOUND + ">";
	}

	public String getEntryNodeName() {
		return WQX_PROVIDER;
	}

	public Map<String, List<String>> getStructure() {
		return COLUMN_POSITION;
	}

	public Map<String, String> getHardBreak() {
		return HARD_BREAK;
	}

	public Map<String, List<ColumnProfile>> getGrouping() {
		return GROUPING;
	}

}
