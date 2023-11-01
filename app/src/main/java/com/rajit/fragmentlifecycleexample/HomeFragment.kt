package com.rajit.fragmentlifecycleexample

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rajit.fragmentlifecycleexample.databinding.FragmentHomeBinding

private const val HOME_TAG = "HomeFragment"

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get(): FragmentHomeBinding = _binding!!

    /**
     * Here, the fragment is attached to an Activity
     * In this case, it is MainActivity and is called every single time
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(HOME_TAG, "onAttach: $HOME_TAG onAttach() Called")
    }

    /**
     * Here, the fragment is created
     * This method is only called once for the entire lifecycle
     *
     * If your fragment needs to receive arguments from its hosting activity,
     * you can access and process those arguments in the onCreate() method.
     *
     * NOTE:
     * This method is not primarily related to UI operations or view creation.
     * It's more about preparing the internal state of the fragment and performing tasks that don't require the fragment's view to be available.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(HOME_TAG, "onCreate: $HOME_TAG onCreate() Called")
    }

    /**
     * This method is called whenever there is a need to create a view
     * For e.g. During initialisation, and when coming back to the fragment from other fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(HOME_TAG, "onCreateView: $HOME_TAG onCreateView() Called")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    /**
     * This method is called when the view has been created
     * But the user still cannot interact with the view at this stage
     *
     * This is also called - During initialisation, and when coming back to the fragment from other fragment
     *
     * NOTE:
     * Always setup onClickListeners in the onViewCreated() method
     * It is a widely accepted convention and common practice
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(HOME_TAG, "onViewCreated: $HOME_TAG onViewCreated() Called")

        binding.sampleText.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ProfileFragment()
                )
                .addToBackStack(null)
                .commit()
        }

    }

    /**
     * It's called when the fragment's view hierarchy has been restored,
     * Typically after the fragment has been recreated due to a configuration change (e.g., screen rotation, language change)
     *
     * This method allows you to restore the state of the fragment's view or its UI components.
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(HOME_TAG, "onViewStateRestored: $HOME_TAG onViewStateRestored() Called")
    }

    /**
     * It is called when the fragment becomes visible to the user, but it is not yet in the foreground.
     * This means that the fragment is about to become partially visible, but it's not yet actively interacting with the user.
     *
     * The [onStart] method is called after the fragment's [onAttach], [onCreate] and [onCreateView] methods have been executed.
     *
     * Here, after the hosted activity's onStart() and onResume() both are called
     * THEN ONLY, the fragment's onStart() is called followed by onResume()
     *
     * COMMON USE CASES:
     * 1. Registering and Unregistering listeners or observers,
     * 2. Preparing data,
     * 3. Performing other setup activities that are necessary when the fragment is just about to become visible.
     */
    override fun onStart() {
        super.onStart()
        Log.d(HOME_TAG, "onStart: $HOME_TAG onStart() Called")
    }

    /**
     * The [onResume] method is called AFTER the [onStart] method.
     * It signifies that the fragment is now in the foreground, visible to the user, and ready to receive user input and interaction.
     *
     * COMMON USE CASES:
     * 1. Starting animations,
     * 2. Refreshing data from a data source,
     * 3. Updating the user interface,
     * 4. Initializing any components that require user interaction.
     */
    override fun onResume() {
        super.onResume()
        Log.d(HOME_TAG, "onResume: $HOME_TAG onResume() Called")
    }

    /**
     * The onPause() method is called when the fragment is about to lose visibility or is partially obscured.
     * This can happen when the user -
     * 1. Navigates to another fragment or activity
     * 2. Or when the fragment goes into the background due to some other event.
     *
     * At this point, the fragment is still partially visible but no longer actively interacting with the user.
     *
     * COMMON USE CASES:
     * 1. Pause animations,
     * 2. Release resources,
     * 3. Stop ongoing tasks, or
     * 4. Save the current state of the fragment in preparation for it potentially being stopped or destroyed.
     */
    override fun onPause() {
        super.onPause()
        Log.d(HOME_TAG, "onPause: $HOME_TAG onPause() Called")
    }

    /**
     * The onStop() method is called when the fragment is no longer visible, and it is not actively running.
     * This usually occurs when the user navigates away from the fragment or when the fragment is replaced by another fragment or activity.
     *
     * The fragment is not visible on the screen at this stage.
     *
     * COMMON USE CASES:
     * 1. Perform cleanup tasks,
     * 2. Release resources that are no longer needed, or
     * 3. Stop background processes associated with the fragment.
     */
    override fun onStop() {
        super.onStop()
        Log.d(HOME_TAG, "onStop: $HOME_TAG onStop() Called")
    }

    /**
     * [onSaveInstanceState] is a callback method in Android that allows you to save the state of a fragment or an activity
     * when it might be destroyed and later recreated,
     * Such as during a configuration change (e.g., screen rotation, language change) or when the system reclaims resources.
     *
     * Before API 28, onSaveInstanceState() is called [BEFORE] the onStop() Callback
     * On API 28 & above, onSaveInstanceState() is called [AFTER] the onStop() Callback
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(HOME_TAG, "onSaveInstanceState: $HOME_TAG onSaveInstanceState() Called")
    }

    /**
     * The onDestroyView() method is a callback in the Android fragment lifecycle.
     * It is called when the view associated with the fragment is being destroyed.
     * This is typically triggered when the fragment is no longer visible, such as when it is removed from the screen or replaced by another fragment.
     *
     * At this stage, the fragment's view hierarchy is dismantled, and the view is removed from the fragment, making it inaccessible.
     * The fragment itself is still retained in memory unless it's explicitly removed or the hosting activity is destroyed.
     *
     * COMMON USE CASES:
     * 1. Release references to views, resources, or other objects that were associated with the fragment's view.
     *
     * It's an appropriate place to clean up UI-related resources and perform any necessary teardown.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(HOME_TAG, "onDestroyView: $HOME_TAG onDestroyView() Called")
        _binding = null
    }

    /**
     * onDestroy() is called when the fragment is being destroyed.
     * This can happen in various scenarios, such as -
     * 1. When the hosting activity is being destroyed or
     * 2. When the fragment is removed using a FragmentTransaction.
     *
     * At this point, the fragment is at the end of its lifecycle.
     * The fragment and its associated view are being destroyed, and it is no longer retained in memory.
     *
     * COMMON USE CASES:
     * 1. Release any remaining resources, unregister listeners, and
     * 2. Perform any final cleanup that is necessary before the fragment is completely removed from memory.
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(HOME_TAG, "onDestroy: $HOME_TAG onDestroy() Called")
    }

}