import SwiftUI

struct ContentView: View {
    @StateObject private var sharedState = SharedState.shared
    
    var body: some View {
        TabView {
            ViewA(sharedState: sharedState)
                .tabItem {
                    Label("View A", systemImage: "a.circle")
                }

            ViewB(sharedState: sharedState)
                .tabItem {
                    Label("View B", systemImage: "b.circle")
                }
        }
    }
}

struct ViewA: View {
    @ObservedObject var sharedState: SharedState

    var body: some View {
        VStack {
        
            Spacer()
            
            VStack(alignment: .leading) {
                Text("Label")
                    .font(.headline)
                TextField("Enter text here", text: $sharedState.textFieldValue)
                                    .textFieldStyle(RoundedBorderTextFieldStyle())
                                    .padding()
                                    .frame(maxWidth: .infinity)
                                    .background(Color(.systemGray6))
                                    .cornerRadius(10)
            }
            .padding(20)
            
            Spacer()
        }
        .navigationTitle("View A")
    }
}

struct ViewB: View {
    @ObservedObject var sharedState: SharedState
    var body: some View {
        ReactNativeView(sharedState: sharedState)
            .edgesIgnoringSafeArea(.all)
            .navigationTitle("View B")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
