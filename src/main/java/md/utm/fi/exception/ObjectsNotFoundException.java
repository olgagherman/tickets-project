package md.utm.fi.exception;

public class ObjectsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public <T> ObjectsNotFoundException(Class<T> objectTypes,
			String... paremeters) {
		super(new StringParser() {
			@SuppressWarnings("hiding")
			public <T> String parseObjects(Class<T> objectTypes,
					String... paremeters) {
				StringBuilder message = new StringBuilder(
						"Objects were not found in the database for ");
				message.append(objectTypes.getSimpleName());
				message.append(" entity, with given parameters: ");
				for (String parameter : paremeters) {
					message.append(", ");
					message.append(parameter);
				}
				return message.toString();
			}
		}.parseObjects(objectTypes, paremeters));

	}

	interface StringParser {
		<T> String parseObjects(Class<T> objectTypes, String... paremeters);
	}
}
