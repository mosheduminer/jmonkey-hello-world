import com.jme3.app.*
import com.jme3.app.state.AbstractAppState
import com.jme3.app.state.AppStateManager
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.Node
import com.jme3.scene.shape.Box
import com.jme3.system.AppSettings

class App : SimpleApplication(BoxState(), StatsAppState(), FlyCamAppState(), DebugKeysAppState()) {
    override fun simpleInitApp() {}
}

class BoxState : AbstractAppState() {
    lateinit var app: SimpleApplication
    override fun initialize(stateManager: AppStateManager?, app: Application?) {
        super.initialize(stateManager, app)
        this.app = app as SimpleApplication

        val box1 = Box(1F, 1F, 1F)
        val blueGeometry = Geometry("Box", box1)
        blueGeometry.localTranslation = Vector3f(1F, -1F, 1F)
        val material1 = Material(this.app.assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        material1.setColor("Color", ColorRGBA.Blue)
        blueGeometry.material = material1

        val box2 = Box(1F, 1F, 1F)
        val redGeometry = Geometry("Box", box2)
        redGeometry.localTranslation = Vector3f(1f, 3f, 1f)
        val material2 = Material(this.app.assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        material2.setColor("Color", ColorRGBA.Red)
        redGeometry.material = material2

        val pivot = Node("Pivot")
        this.app.rootNode.attachChild(pivot)
        pivot.attachChild(blueGeometry)
        pivot.attachChild(redGeometry)
    }
}

fun main() {
    val app = App()
    val settings = AppSettings(true)
    settings.title = "Hello World!"
    app.setSettings(settings)
    app.isShowSettings = false

    app.start()
}