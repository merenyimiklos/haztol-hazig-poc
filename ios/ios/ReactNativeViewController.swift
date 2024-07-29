import UIKit
import React

class ReactNativeViewController: UIViewController {

    var sharedState: SharedState?
    var rootView: RCTRootView?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupReactNativeView()
    }
    
    func setupReactNativeView() {
            guard let a = URL(string: "http://localhost:8081/index.bundle?platform=ios") else {
                NSLog("Invalid URL")
                return
            }
            let jsCodeLocation: URL

            #if DEBUG
              jsCodeLocation = a
            #else
              jsCodeLocation = Bundle.main.url(forResource: "main", withExtension: "jsbundle")!
            #endif
        
            let initialProperties: NSDictionary = ["inputText": sharedState?.textFieldValue ?? ""]
            
            rootView = RCTRootView(
                bundleURL: jsCodeLocation,
                moduleName: "integrated",
                initialProperties: initialProperties as [NSObject : AnyObject],
                launchOptions: nil
            )
            
            self.view = rootView
        }
    
    func updateReactNativeView(with newValue: String) {
           guard let rootView = rootView else { return }
           rootView.appProperties = ["inputText": newValue]
    }
}
