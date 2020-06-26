package co.nimblehq.ui.screens.second

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import co.nimblehq.R
import co.nimblehq.ui.base.BaseActivity
import co.nimblehq.ui.screens.Const
import co.nimblehq.ui.screens.home.Data
import kotlinx.android.synthetic.main.activity_second.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnNeverAskAgain
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions
import kotlin.reflect.KClass


@RuntimePermissions
class SecondActivity : BaseActivity<SecondViewModel>() {

    override val viewModelClass: KClass<SecondViewModel> = SecondViewModel::class

    override val layoutRes: Int = R.layout.activity_second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btOpenCamera.setOnClickListener { openCameraWithPermissionCheck() }
    }

    override fun bindViewModel() {
        viewModel.outputs.setPersistedData() bindTo ::bindPersistedData
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    fun openCamera() {
        startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    fun showDeniedForCamera() {
        Toast.makeText(this, "Permission camera denied", Toast.LENGTH_SHORT).show()
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    fun showNeverAskForCamera() {
        Toast.makeText(this, "Permission camera never ask", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    private fun bindPersistedData(data: Data) {
        persistTextView.text = data.content
    }

    companion object {
        @JvmStatic
        fun show(from: Context, data: Data) {
            val intent = Intent(from, SecondActivity::class.java)
            intent.putExtra(Const.EXTRAS_DATA, data)
            from.startActivity(intent)
        }
    }
}
