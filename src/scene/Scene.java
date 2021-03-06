package scene;

import elements.*;
import geometries.Box;
import geometries.Geometries;
import geometries.Intersectable;
import primitives.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    private final String _name;
    private final Geometries _geometries = new Geometries();

    private Color _background;
    private Camera _camera;
    private double _distance;
    private AmbientLight _ambientLight;
    private List<LightSource> _lights = null;

    public List<Box> get_box() {
        return _box;
    }

    public void set_box(List<Box> _box) {
        this._box = _box;
    }

    private  List<Box> _box;


    public AmbientLight getAmbientLight() {
        return _ambientLight;
    }

    public Camera getCamera() {
        return _camera;
    }

    public Geometries getGeometries() {
        return _geometries;
    }

    public double getDistance() {
        return _distance;
    }

    public Scene(String _sceneName) {
        this._name = _sceneName;
        _box=new LinkedList<Box>();
    }

    public Color getBackground() {
        return this._background;
    }

    public void set_background(Color _background) {
        this._background = _background;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public void set_distance(double _distance) {
        this._distance = _distance;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void set_lights(List<LightSource> _lights) {
        this._lights = _lights;
    }

    public List<LightSource> getLightSources() {
        return _lights;
    }

    public void addGeometries(Intersectable... intersectables) {
        for (Intersectable i : intersectables) {
            _geometries.add(i);
        }
    }

    public void addBox(Intersectable... intersectables) {
        for (Intersectable i : intersectables) {
            _box.add(new Box(i));//enter boxes to scene
        }
    }

    public void removeGeometries(Intersectable... intersectables) {
        for (Intersectable i : intersectables) {
            _geometries.remove(i);
        }
    }

    public void addLights(LightSource light) {
        if (_lights == null) {
            _lights = new ArrayList<>();
        }
        _lights.add(light);
    }

    public void setBackground(Color _background) {
        this._background = _background;
    }

    public void setCamera(Camera _camera) {
        this._camera = _camera;
    }

    public void setDistance(double _distance) {
        this._distance = _distance;
    }

    public void setAmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void setLights(List<LightSource> _lights) {
        this._lights = _lights;
    }

    public static class SceneBuilder {
        private String name;
        private Color background;
        private Camera camera;
        private double distance;
        private AmbientLight ambientLight;

        public SceneBuilder(String name) {
            this.name = name;
        }

        public SceneBuilder addBackground(Color background) {
            this.background = background;
            return this;
        }

        public SceneBuilder addCamera(Camera camera) {
            this.camera = camera;
            return this;
        }

        public SceneBuilder addDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public SceneBuilder addAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }
//
        public Scene build() {
            Scene scene = new Scene(this.name);
            scene._camera = this.camera;
            scene._distance = this.distance;
            scene._background = this.background;
            scene._ambientLight = this.ambientLight;
            validateUserObject(scene);
            return scene;
        }

        private void validateUserObject(Scene scene) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}