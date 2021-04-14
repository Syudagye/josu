package fr.syudagye.josu.requests;

public class Route {

    /* BEATMAPS */

    public static final Route LOOKUP =              new Route(Method.GET, "beatmaps/lookup");
    public static final Route BEATMAP =         new Route(Method.GET, "beatmaps/{beatmap_id}");
    public static final Route BEATMAP_SCORES =  new Route(Method.GET, "beatmaps/{beatmap_id}/scores");
    public static final Route BEATMAP_USER_SCORE =   new Route(Method.GET, "beatmaps/{beatmap_id}/scores/users/{user}");

    private Method method;
    private String route;
    private int paramsCount;

    public Route(Method method, String route)
    {
        this.method = method;
        this.route = route;
        this.paramsCount = (int) route.chars()
                .filter(i -> i == '{')
                .count();
        if (route.chars().filter(i -> i == '}').count() != paramsCount)
            throw new IllegalArgumentException("Wrong route formatting: incomplete {} pairs: " + route);
    }

    public String compile(String... params)
    {
        if (params.length != paramsCount)
            throw new IllegalArgumentException(String.format("Expected %s params: %s", paramsCount, route));

        StringBuilder compiledRoute = new StringBuilder(route);

        for (String param : params) {
            compiledRoute.replace(
                    compiledRoute.indexOf("{"),
                    compiledRoute.indexOf("}") + 1,
                    param
            );
        }

        return compiledRoute.toString();
    }

    public Method getMethod() {
        return method;
    }

    public String getRoute() {
        return route;
    }

    public int getParamsCount() {
        return paramsCount;
    }

    public enum Method {
        GET
    }

}
