using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfTemplate
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ObservableCollection<MyTask> listTasks;
        MyTask newTask = new();
        public MainWindow()
        {
            InitializeComponent();

            List<string> listPhones = new() { "nokia", "phony", "sasung", "top za svoi dengi", "yabloko" };
            phones.ItemsSource = listPhones;

            listTasks = new() {
                new MyTask() {Name = "Sleep", Description = "Go sleep", Priority=1},
                new MyTask() {Name = "Sleep again", Description = "Go sleep", Priority=1},
                new MyTask() {Name = "Sleep", Priority=2}

            };
            tasks.ItemsSource = listTasks;

            st.DataContext = newTask;
            btnAdd.Click += BtnAdd_Click;
        }

        private void BtnAdd_Click(object sender, RoutedEventArgs e)
        {
            listTasks.Add(new MyTask()
            {
                Name = newTask.Name,
                Description = newTask.Description,
                Priority = newTask.Priority}
            );
        }
    }

    internal class MyTask : IDataErrorInfo
    {

        public string? Name { get; set; }
        public string? Description { get; set; }
        public int Priority { get; set; }

        public string this[string columnName]
        {
            get
            {
                string err = string.Empty;
                switch (columnName)
                {
                    case nameof(Name):
                        break;
                    case nameof(Description):
                        break;
                    case nameof(Priority):
                        if (this.Priority < 0 || this.Priority > 10)
                            err = "Wrong priority";
                        break;
                }
                return err;
            }
        }

        public string Error => throw new NotImplementedException();
    }
}