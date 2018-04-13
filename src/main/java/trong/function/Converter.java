package trong.function;

@FunctionalInterface
public interface Converter<F, T> {
  T convert(F from);
}
