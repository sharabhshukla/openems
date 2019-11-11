package io.openems.edge.evcs.cluster;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(//
		name = "EVCS Cluster", //
		description = "Limits the maximum charging power of all electric vehicle charging stations, depending on the maximum ecxess power.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "evcsCluster0";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Hardware current limit", description = "The maximum current in Ampere that can be used by the Cable.", required = true)
	int hardwareCurrentLimit() default 30;

	@AttributeDefinition(name = "Evcs-IDs", description = "IDs of EVCS devices ordered by the priority. (Only Managed Evcss)")
	String[] evcs_ids() default { "evcs0", "evcs1" };

	@AttributeDefinition(name = "Evcs target filter", description = "This is auto-generated by 'Evcs-IDs'.")
	String Evcs_target() default "";

	@AttributeDefinition(name = "Ess-ID", description = "ID of Ess device.")
	String ess_id() default "ess0";

	String webconsole_configurationFactory_nameHint() default "EVCS Cluster [{id}]";

}
